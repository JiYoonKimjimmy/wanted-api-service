package me.jimmyberg.wanted.api.v0.hello;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/hello")
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Operation(summary = "Hello 등록 API")
    @PostMapping
    public Hello save(@RequestBody Hello hello) {
        return helloService.save(hello);
    }

    @Operation(summary = "Hello 조회 by id API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success", content = @Content(schema = @Schema(implementation = Hello.class)))
    })
    @GetMapping("/{id}")
    public Hello findOne(
            @Parameter(description = "Hello.ID", required = true) @PathVariable long id
    ) {
        return helloService.findOneById(id);
    }

    @Operation(summary = "Hello 전체 조회 API")
    @GetMapping
    public List<Hello> findAll() {
        return helloService.findAll();
    }

    @Operation(summary = "Hello 전체 조회 by text API")
    @GetMapping("/conditions")
    public List<Hello> findAllByText(
            @RequestParam("text") String text
    ) {
        return helloService.findAllByText(text);
    }

}
