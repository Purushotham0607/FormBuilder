package com.test.formbuilder.conversion;
import com.test.formbuilder.repository.FormRepository;
import com.test.formbuilder.entity.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomIdGeneratorServiceForm {

    @Autowired
    private FormRepository formRepository;

    public String generateNextId() {
        String lastId = formRepository.findTopByOrderByIdDesc()
                                      .map(Form::getId)
                                      .orElse("ID00000");
        int num = Integer.parseInt(lastId.substring(3));
        num++;
        return String.format("ID%05d", num);
    }
}
