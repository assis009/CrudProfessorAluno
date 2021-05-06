package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Professor;

public interface IProfessorController {

	
	public void inserirProfessor (Professor p) throws ClassNotFoundException, SQLException;
	public void atualizarProfessor (Professor p) throws ClassNotFoundException, SQLException;
	public void excluirProfessor (Professor p) throws ClassNotFoundException, SQLException;
	public void buscaProfessor (Professor p) throws ClassNotFoundException, SQLException;
	public void buscarProfessores () throws ClassNotFoundException, SQLException;
	
}
