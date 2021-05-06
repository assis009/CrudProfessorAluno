package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Disciplina;

public interface IDisciplinaDao  {
	
	public void insereDisciplina (Disciplina d) throws SQLException  ;
	public void atualizaDisciplina (Disciplina d) throws SQLException ;
	public void excluiDisciplina (Disciplina d) throws SQLException   ;
	public Disciplina buscaDisciplina (Disciplina d) throws SQLException ;
	public List<Disciplina> buscaDisciplinas () throws SQLException    ;
}
