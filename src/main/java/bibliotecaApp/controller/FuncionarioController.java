package bibliotecaApp.controller;

import bibliotecaApp.model.domain.Funcionario;
import bibliotecaApp.model.service.FuncionarioService;
import spark.Route;

public class FuncionarioController {

	public static Route obterLista = (req, res) -> {
		
		return FuncionarioService.obterLista();
	};
	
	public static Route incluir = (req, res) -> {
		
		String oNome = req.params("nome");
		
		Funcionario funcionario = new Funcionario(oNome);
		
		FuncionarioService.incluir(funcionario);
		
		return "Inclus�o realizada com sucesso: "+funcionario+"!";
	};
	
	public static Route excluir = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Funcionario funcionario = FuncionarioService.obterPorId(index);		

		FuncionarioService.excluir(index);		
		
		return "Exclus�o realizada com sucesso: "+funcionario+"!";
	};
	
	public static Route obter = (req, res) -> {
		
		Integer index = Integer.valueOf(req.params("id"));
		
		Funcionario funcionario = FuncionarioService.obterPorId(index);		
				
		return "Recupera��o realizada com sucesso: "+funcionario+"!";
	};
}