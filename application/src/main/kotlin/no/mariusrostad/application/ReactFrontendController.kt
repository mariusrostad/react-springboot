package no.mariusrostad.application

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.http.CacheControl
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.util.FileCopyUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.io.IOException
import java.io.InputStreamReader
import java.io.UncheckedIOException
import java.nio.charset.StandardCharsets

@Controller
class ReactFrontendController(
    @Value("classpath:/static/index.html") val indexHtml: Resource
) {

    @GetMapping(path = ["", "/", "/**{:^[^.]+$}"], produces = ["text/html"])
    @ResponseBody
    fun index(): ResponseEntity<String> {
        return ResponseEntity.ok().cacheControl(CacheControl.noStore()).body(loadResourceAsString(indexHtml))
    }

    private fun loadResourceAsString(resource: Resource): String {
        try {
            InputStreamReader(resource.inputStream, StandardCharsets.UTF_8).use { reader ->
                return FileCopyUtils.copyToString(
                    reader
                )
            }
        } catch (e: IOException) {
            throw UncheckedIOException(e)
        }
    }
}
