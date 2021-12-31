package co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.implementation;

import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Entities.ProcedimientosEntity;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Repository.ProcedimientosRepository;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.Services.ProcedimientosService;
import co.edu.utp.isc.gia.sistema_de_historias_clinicas.dto.ProcedimientosDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedimientosImpl implements ProcedimientosService {

    @Autowired
    private ProcedimientosRepository procedimientosRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public ProcedimientosImpl(){
    }

    public ProcedimientosImpl(ProcedimientosRepository procedimientosRepository,
                              ModelMapper modelMapper){
        this.procedimientosRepository = procedimientosRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProcedimientosDTO guardarProcedimientos(ProcedimientosDTO procedimientosDTO) {

        ProcedimientosEntity procedimientos = procedimientosRepository.save(
                modelMapper.map(procedimientosDTO, ProcedimientosEntity.class));

        ProcedimientosDTO procedimientosDTO1 = modelMapper.map(procedimientos, ProcedimientosDTO.class);

        return procedimientosDTO1;
    }

    @Override
    public boolean actualizarProcedimientos(ProcedimientosDTO procedimientosDTO) {

        if (procedimientosRepository.existsById(procedimientosDTO.getId())){
            ProcedimientosEntity procedimientos = procedimientosRepository.save(modelMapper.map(
                    procedimientosDTO, ProcedimientosEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarProcedimientos(Long id) {

        if (procedimientosRepository.existsById(id)){
            procedimientosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
