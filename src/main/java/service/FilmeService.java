package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilmeService {
    import com.example.filme.dto.filmeDTO;
import com.example.filme.model.Filme;
import com.example.filme.repository.filmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

    @Service
    public class LivroService {
        @Autowired
        private FilmeRepository livroRepository;

        private FilmeDTO toDTO(Filme livro) {
            FilmeDTO dto = new FilmeDTO();
            dto.setClassifi(o.getId());;
            dto.setTitulo(livro.getTitulo());
            dto.setGenero(livro.getGenero());
            dto.setAno(livro.getAno());
            return dto;
        }

        private Livro toEntity(LivroDTO dto) {
            Livro livro = new Livro();
            livro.setId(dto.getId());
            livro.setTitulo(dto.getTitulo());
            livro.setAutor(dto.getAutor());
            livro.setAno(dto.getAno());
            return livro;
        }

        public List<LivroDTO> listar() {
            return livroRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
        }
        public Optional<LivroDTO> buscar(Long id) { return livroRepository.findById(id).map(this::toDTO); }

        public LivroDTO salvar(LivroDTO dto) {
            Livro livro = toEntity(dto);
            return toDTO(livroRepository.save(livro));
        }

        public LivroDTO atualizar(Long id, LivroDTO dto) {
            dto.setId(id);
            Livro livro = toEntity(dto);
            return toDTO(livroRepository.save(livro));
        }

        public void deletar(Long id) {livroRepository.deleteById(id);}
    }

}
