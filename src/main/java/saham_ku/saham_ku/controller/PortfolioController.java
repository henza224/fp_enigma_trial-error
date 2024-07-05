package saham_ku.saham_ku.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saham_ku.saham_ku.model.Portfolio;
import saham_ku.saham_ku.model.User;
import saham_ku.saham_ku.service.PortfolioDetailService;
import saham_ku.saham_ku.service.PortfolioService;
import saham_ku.saham_ku.utils.DTO.PortfolioDetailDTO;
import saham_ku.saham_ku.utils.response.PageWrapper;
import saham_ku.saham_ku.utils.response.Res;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final PortfolioDetailService portfolioDetailService;

    @PostMapping("/buy")
    public ResponseEntity<?> buy (@RequestBody PortfolioDetailDTO req){
        return Res.renderJson(
                portfolioDetailService.create(req)
                        ,"Success buy", HttpStatus.CREATED
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Portfolio req){
        return Res.renderJson(
                portfolioService.create(req),"Create",HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam (required = false)Integer totalAmount,
                                    @RequestParam (required = false)User id,
                                    @PageableDefault(page = 0, size = 10)Pageable pageable){
        Page<Portfolio> res = portfolioService.getAll(id,totalAmount,pageable);
        PageWrapper<Portfolio> result = new PageWrapper<>(res);
        return Res.renderJson(
                result,"found",HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Portfolio getOne(@PathVariable Integer id){
        return portfolioService.getOne(id);
    }
    @PutMapping
    public Portfolio update(@PathVariable Integer id,@RequestBody Portfolio req ){
        return portfolioService.update(id,req);
    }
    @DeleteMapping
    public void delete(@PathVariable Integer id){
        portfolioService.delete(id);
    }

}

