package vsu.labs.crypto.controllers.algs;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vsu.labs.crypto.service.algs.Wavelet.WaveletService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/wavelet")
@AllArgsConstructor
public class WaveletController {
    private final String pathToRoot = "src/main/resources/pictures";
    private final WaveletService storageService;

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("id") int id, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null) {
            File dir = new File(pathToRoot);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String nameOfPicture = file.getOriginalFilename();
            file.transferTo(new File(pathToRoot + "/" + nameOfPicture));
            //todo wavelet

        }
        return null;
    }

    @GetMapping("/files")
    @ResponseBody
    public ResponseEntity<Resource> serveFile() throws MalformedURLException, URISyntaxException {
        String path = "1true.png";
        Resource file = storageService.loadAsResource(path);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
