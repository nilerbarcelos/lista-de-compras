package com.nilerbarcelos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.nilerbarcelos.dto.ProdutoDto;
import com.nilerbarcelos.model.ProdutoModel;
import com.nilerbarcelos.repository.ProdutoRepository;

@Path("/api")
public class RestController {

	private final ProdutoRepository produtoRepository = new ProdutoRepository();

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public void cadastrar(ProdutoDto produto) {

		ProdutoModel entity = new ProdutoModel();

		entity.setNome(produto.getNome());
		entity.setValor(produto.getValor());
		entity.setQuantidade(produto.getQuantidade());
		produtoRepository.salvar(entity);
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/lista-produtos")
	public List<ProdutoDto> listaProdutos() {

		List<ProdutoDto> produtos = new ArrayList<ProdutoDto>();
		List<ProdutoModel> listaProdutos = produtoRepository.buscaTodosProdutos();
		for (ProdutoModel entity : listaProdutos) {
			produtos.add(
					new ProdutoDto(entity.getCodigo(), entity.getNome(), entity.getValor(), entity.getQuantidade()));
		}

		return produtos;
	}
}
