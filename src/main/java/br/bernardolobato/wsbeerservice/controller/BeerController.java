package br.bernardolobato.wsbeerservice.controller;

import br.bernardolobato.wsbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> get(@PathVariable UUID beerId) {
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BeerDto> create(@RequestBody BeerDto beerDto) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> update(@RequestBody BeerDto beerDto,  @PathVariable UUID beerId)  {
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<BeerDto> delete(@PathVariable UUID beerId)  {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
