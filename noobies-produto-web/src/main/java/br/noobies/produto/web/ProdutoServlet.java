package br.noobies.produto.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabriela.vsmarques
 */


    
@WebServlet(name = "ProdutoServlet", urlPatterns ={"/produto"})    
public class ProdutoServlet extends HttpServlet {
    
     protected void processarRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            // RECUPERA INFORMACOES DA REQUISICAO
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String precoCompra = request.getParameter("precoCompra");
            String precoVenda = request.getParameter("precoVenda");
            String quantidade = request.getParameter("quantidade");
            String[] categoriasArray = request.getParameterValues("categoria");
            
             // VALIDAR DADOS
                boolean temErros = false;
        
         if (nome == null || nome.length() == 0) {
             temErros = true;
             request.setAttribute("erroNome", "Nome não preenchido");
         }
         if (descricao == null || descricao.length() == 0) {
             temErros = true;
             request.setAttribute("erroDescricao", "Descrição não preenchida");
         }
         if (precoCompra == null || precoCompra.length() == 0) {
             temErros = true;
             request.setAttribute("erroprecoCompra", "Preço Compra não preenchida");
         }
         if (precoVenda == null || precoVenda.length() == 0) {
             temErros = true;
             request.setAttribute("erroprecoVenda", "Preço Venda não preenchida");
         }
         if (quantidade == null || quantidade.length() == 0) {
             temErros = true;
             request.setAttribute("erroQuantidade", "Categoria não preenchida");
         }
         
        if (categoriasArray == null || categoriasArray.length == 0) {
            temErros = true;
            request.setAttribute("erroCategoria", "Categoria não selecionada");
        }

         if (temErros) {
             // REAPRESENTA FORMULARIO INDICANDO OS ERROS
             RequestDispatcher dispatcher = request.getRequestDispatcher("formularioProduto.jsp");
             dispatcher.forward(request, response);
         }

        // ARMAZENANDO VALORES COMO ATRIBUTOS
        request.setAttribute("metodoHttp", metodoHttp);
        request.setAttribute("nome", nome);
        request.setAttribute("descricao", descricao);
        request.setAttribute("precoCompra", precoCompra);
        request.setAttribute("precoVenda", precoVenda);
        request.setAttribute("quantidade", quantidade);
        request.setAttribute("categoriasArray", categoriasArray);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resultadoProduto.jsp");
        dispatcher.forward(request, response); 
    }
     
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processarRequisicao("GET", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processarRequisicao("POST", request, response);
    }
    
}
