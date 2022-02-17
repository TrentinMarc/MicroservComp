package com.TFT.SingerService.controller;

import com.TFT.SingerService.bean.Singer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "SWAAAAG", description = "DripDrip")
@RequestMapping("/singers")
public class SingerServiceController {
    public static final List<Singer> singers = new ArrayList<Singer>() {
        private static final long serialVersionUID = -3970206781360313502L;

        {
            add(new Singer(1,"Bashar", "Barakah Jackson", "Pop Smoke", 21, false));
            add(new Singer(2,"Rakim", "Athelaston Mayers", "Asap Rocky", 33, true));
            add(new Singer(3,"Gerald", "Earl Gillum", "G-Eazy", 32, true));
        }
    };

    @ApiOperation(value = "Get list of Singers", response = Iterable.class, tags = "getSingers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(
            name = "getSingers",
            method = RequestMethod.GET
    )
    public List<Singer> getSingers() {
        try {
            return singers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @ApiOperation(value = "Get specific Singer in the System ", response = Singer.class, tags = "getSingerById")
    @RequestMapping(
            name = "getSingerById",
            method = RequestMethod.GET,
            value = "/{id}"
    )
    public Singer getSingerById(@PathVariable int id){
        try {
            return singers.stream()
                    .filter(singer -> id == singer.getId())
                    .findAny()
                    .orElse(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @ApiOperation(value = "Get specific Singers in the System ", response = Iterable.class, tags = "getSingerByAliveness")
    @RequestMapping(
            name = "getSingerByAliveness",
            method = RequestMethod.GET,
            value = "alive/{isAlive}"
    )
    public List<Singer> getSingersByAliveness(@PathVariable boolean isAlive){
        try {
            return singers.stream()
                    .filter(singer -> isAlive == singer.isAlive())
                    .collect(Collectors.toList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
