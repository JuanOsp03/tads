package co.edu.umanizales.tads.controller;

import co.edu.umanizales.tads.controller.dto.ResponseDTO;
import co.edu.umanizales.tads.model.Node;
import co.edu.umanizales.tads.services.ListaSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/listse")
public class ListSEController {

    @Autowired
    private ListaSEService listaSEService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getKids(){
        Node findHead = listaSEService.getKids();
        if (findHead != null) {
            return new ResponseEntity<>(new ResponseDTO(200,listaSEService.getKids(),null), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ResponseDTO(409, "No existen niños, por lo tanto no se puede realizar la acción deseada", null),
                    HttpStatus.BAD_REQUEST);
        }
    }
//-------------------- PROTOTIPOS DE METODOS DE EXAMEN EN EL CONTROLLER DE LA ListSE //

}//fin c_Controller