package com.bision.mini.repository;

import com.bision.mini.dto.BoardDTO;
import com.bision.mini.dto.BoardFileDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public BoardDTO save(BoardDTO boardDTO) {
        sql.insert("Board.save", boardDTO);
        return boardDTO;
    }
    public List<BoardDTO> findAll() {return sql.selectList("Board.findAll");}
    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }
    public BoardDTO findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }
    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }
    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }
    public void saveFile(BoardFileDTO boardFileDTO) {
        sql.insert("Board.saveFile", boardFileDTO);
    }
    public List<BoardFileDTO> findFile(Long id) {
        return sql.selectList("Board.findFile", id);
    }
}