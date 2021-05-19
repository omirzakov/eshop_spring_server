package com.csse.restapi.restapireact.rest;

import com.csse.restapi.restapireact.entities.CarCredit;
import com.csse.restapi.restapireact.entities.Users;
import com.csse.restapi.restapireact.repositories.CarCreditRepository;
import com.csse.restapi.restapireact.security.jwt.JwtProvider;
import com.csse.restapi.restapireact.services.PdfService;
import com.csse.restapi.restapireact.services.UserService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
public class CarCreditController {

    @Autowired
    public CarCreditRepository carCreditRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    private final PdfService pdfService;

    public CarCreditController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping(value = "/carcredits")
    public ResponseEntity<?> getAllItems(){
        List<CarCredit> items = carCreditRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "Fixed rate task with one second initial delay - " + now);
    }

    @PostMapping(value = "/addcredit")
    public ResponseEntity<?> addCarGallery(@RequestBody CarCredit credit) {
        carCreditRepository.save(credit);

        return new ResponseEntity<>("items", HttpStatus.OK);
    }

    @GetMapping(value = "/getcredits/{token}")
    public ResponseEntity<?> getCredits(@PathVariable String token) {
        System.out.println(token);

        String email = jwtProvider.getLoginFromToken(token);
        Users currentUser = null;

        if(email != null && email.length() > 0) {
            currentUser = userService.findByLogin(email);
        }

        List<CarCredit> credits = carCreditRepository.findAllByUser(currentUser);

        return new ResponseEntity<>(credits, HttpStatus.OK);
    }

    @GetMapping("/download-pdf/{id}")
    public void downloadPDFResource(HttpServletResponse response, @PathVariable Long id) {
        try {
            CarCredit credit = carCreditRepository.findById(id).get();

            Path file = Paths.get(pdfService.generatePdf(credit).getAbsolutePath());
            if (Files.exists(file)) {

                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition",
                        "attachment; filename=" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }




}