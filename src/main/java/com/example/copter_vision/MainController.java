package com.example.copter_vision;

import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@Controller
public class MainController {

    @PostMapping("/example")
    public ResponseEntity postExample(@RequestBody String body) throws IOException {
        File file = new File("C:/Users/Ozi/ideaProjects/copter_vision/src/main/resources/templates/video.html");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(body);
        bufferedWriter.close();
        return ResponseEntity.ok("success");

    }

    @GetMapping("/example")
    @ResponseBody
    public String getExample() {
        File file = new File("C:/Users/Ozi/ideaProjects/copter_vision/src/main/resources/templates/video.html");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            bufferedReader.close();
            return stringBuffer.toString() != null ? stringBuffer.toString() : "<html><body>none</body></html>";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "<html><body>none</body></html>";
        } catch (IOException e) {
            e.printStackTrace();
            return "<html><body>none</body></html>";
        }

    }

}
