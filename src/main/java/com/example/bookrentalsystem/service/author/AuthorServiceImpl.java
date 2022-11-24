package com.example.bookrentalsystem.service.author;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.mapper.AuthorDetailMapper;
import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.pojo.author.AuthorDetailRequestPojo;
import com.example.bookrentalsystem.pojo.author.AuthorDetailResponsePojo;
import com.example.bookrentalsystem.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDetailRequestPojo authorDetailRequestPojo;

    private final ObjectMapper objectMapper;

    private final AuthorRepository authorRepository;

    private final AuthorDetailMapper authorDetailMapper;

    public AuthorServiceImpl(AuthorDetailRequestPojo authorDetailRequestPojo, ObjectMapper objectMapper, AuthorRepository authorRepository, AuthorDetailMapper authorDetailMapper) {
        this.authorDetailRequestPojo = authorDetailRequestPojo;
        this.objectMapper = objectMapper;
        this.authorRepository = authorRepository;
        this.authorDetailMapper = authorDetailMapper;
    }

    @Override
    public List<AuthorDetailResponsePojo> getAuthor() {
        return authorDetailMapper.getAllAuthor();
    }

    @Override
    public void deleteAuthorById(Integer authorId) throws AppException {
        Optional<Author> exists=authorRepository.findById(authorId);
        if (!exists.isPresent()){
            throw new AppException(("Author with given author id" + authorId+" doesnot exist"));
        }
        else if (exists.isPresent()){
            authorRepository.deleteById(authorId);
        }
    }

    @Override
    public AuthorDetailResponsePojo getAuthorById(Integer authorId) throws AppException {
        Optional<Author> exists = authorRepository.findById(authorId);
        if (!exists.isPresent()) {
            throw new AppException(("Author with given author id" + authorId + " doesnot exist"));
        } else {
            return authorDetailMapper.getAuthorById(authorId);
        }
    }

    @Override
    public void saveAuthorDetails(AuthorDetailRequestPojo authorDetailRequestPojo) {

        Author author;
        if (authorDetailRequestPojo.getAuthorId() != null)
            author = authorRepository.findById(authorDetailRequestPojo.getAuthorId()).orElse(new Author());
        author = objectMapper.convertValue(authorDetailRequestPojo, Author.class);
        authorRepository.save(author);

    }
}
