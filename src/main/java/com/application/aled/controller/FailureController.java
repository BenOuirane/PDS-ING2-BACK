package com.application.aled.controller;

import com.application.aled.entity.Failure;
import com.application.aled.repository.FailureRepository;
import com.application.aled.service.FailureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class FailureController {

    /*
     * Annotation Cross Origins :
     * CrossOrigin allows an external domain to access
     * our data, our web pages
     *
     * Here, as we put '*', we agree that every
     * domain access our pages
     */

    /*
     * Annotation Request Mapping :
     * RequestMapping gives us the base element of our routes :
     * Here, we have http://{localhost} or {172.31.254.61}/api/...
     */




        @Autowired
        FailureRepository repository;

        @Autowired
        FailureServiceImpl failureService;

        /*
         * Annotation GetMapping :
         * GetMapping gives us the route to get to the getAllFailures() function :
         * Here, we have http://{localhost} or {172.31.254.61}/api/failures
         */
        @GetMapping("/failures")
        public List<Failure> getAllFailures() {
            System.out.println("Get all Failures...");

            List<Failure> failures = failureService.getFailures();

            return failures;
        }

        /*
         * Annotation @PostMapping :
         * @PostMapping gives us the route to get to the postFailure() function :
         * Here, we have http://{localhost} or {172.31.254.61}/api/failures/create
         */

        /*
         * Annotation @RequestBody :
         * With this annotation, we say that our request (from the
         * fronend app) will have a user in his body
         * and that it will be our parameter for this function
         */

        @GetMapping("/failures/year")
        public int getFailuresByYear(@RequestParam int year) {

        int failureByYear = failureService.getFailuresByYear(year).size();

        return failureByYear ;
    }

    @GetMapping("/failures/month")
    public int getFailuresByYearAndMonth(@RequestParam int year, int month) {

        int failuresByMonth = failureService.getFailuresByYearAndMonth(year, month).size();

        return failuresByMonth;
    }
    @GetMapping("/failures/day")
    public int getFailuresByDay(@RequestParam int year, int month, int day) {

        int failuresByDay = failureService.getFailuresByDay(year, month, day).size();

        return failuresByDay ;
    }

    @GetMapping("/failures/simulation")
    public List<Failure> getSimulation() {

        List<Failure> failures = failureService.launchSimulation();

        return failures;
    }





}
