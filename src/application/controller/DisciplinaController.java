package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Disciplina;
import application.persistence.DisciplinaDao;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DisciplinaController implements IDisciplinaController {
	
	private TextField tfCodigoDisciplina;
	private TextField tfNomeDisciplina;
	private TextField tfCodigoProfessorDisciplina;
	private Label lblNomeProfessor;
	private TextArea taListaDisciplina;
	
	

	public DisciplinaController(TextField tfCodigoDisciplina, TextField tfNomeDisciplina,
			TextField tfCodigoProfessorDisciplina, Label lblNomeProfessor, TextArea taListaDisciplina) {
		this.tfCodigoDisciplina = tfCodigoDisciplina;
		this.tfNomeDisciplina = tfNomeDisciplina;
		this.tfCodigoProfessorDisciplina = tfCodigoProfessorDisciplina;
		this.lblNomeProfessor = lblNomeProfessor;
		this.taListaDisciplina = taListaDisciplina;
	}

	@Override
	public void inserirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
		DisciplinaDao dDao = new DisciplinaDao ();
		dDao.insereDisciplina(d);
		limpaCampos();
		buscarDisciplinas();
		
	}

	@Override
	public void atualizarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
		DisciplinaDao dDao = new DisciplinaDao ();
		dDao.atualizaDisciplina(d);
		limpaCampos();
		buscarDisciplinas();
		
	}

	@Override
	public void excluirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
		DisciplinaDao dDao = new DisciplinaDao ();
		dDao.excluiDisciplina(d);
		limpaCampos();
		buscarDisciplinas();
		
	}

	@Override
	public void buscaDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
		limpaCampos();
		DisciplinaDao dDao = new DisciplinaDao ();
		d = dDao.buscaDisciplina(d);
		tfCodigoDisciplina.setText(String.valueOf(d.getCodigo()));
		tfNomeDisciplina.setText(d.getNome());
		tfCodigoProfessorDisciplina.setText(String.valueOf(d.getProfessor().getCodigo()));
		lblNomeProfessor.setText(d.getProfessor().getNome());
	}

	@Override
	public void buscarDisciplinas() throws ClassNotFoundException, SQLException {
		limpaCampos();
		
		DisciplinaDao dDao = new DisciplinaDao();
		
		List<Disciplina> listaDisciplinas = dDao.buscaDisciplinas();
		
		taListaDisciplina.setText("");
		
		StringBuffer sb = new StringBuffer("Codigo \t\t\t\tNome\t\t\t\t\tProfessor\n");
		
		for (Disciplina d: listaDisciplinas) {
				sb.append(d.getCodigo()+ "\t\t\t\t"+d.getNome()+"\t\t\t\t"+d.getProfessor()+"\n");
				
		}
		
		taListaDisciplina.setText(sb.toString());
		
	}
	
	private void limpaCampos() {
		
		tfCodigoDisciplina.setText("");
		tfNomeDisciplina.setText("");
		tfCodigoProfessorDisciplina.setText("");
		lblNomeProfessor.setText("Nome do Professor");
		
		
	}

}
