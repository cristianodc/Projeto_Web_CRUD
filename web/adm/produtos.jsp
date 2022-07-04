<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="_inc/_verificasession.jsp" %>
<%@include file="_inc/_header.jsp" %>
 <jsp:useBean class="br.com.projetoloja.repository.ProdutoDAO" id="listaP" />
 <div class="container">
            <div class="row">
              
              <%@include file="_inc/_menu.jsp" %>

              <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h2>Lista das Produtos</h2>
                    <a href="produto_insert.jsp" class="btn btn-info">Cadastrar Produtos</a>
                </div>
                
                <div class="table-responsive">
                  <table class="table table-striped table-sm">
                    <thead>
                      <tr>
                        <th scope="col">Cod</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Peso</th>
                         <th scope="col">Destaques</th>
                          <th scope="col">Ativo</th>
                        <th scope="col">Opções</th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaP.produtos}" var="prod">
                      <tr>
                        <td>${prod.idprodutos}</td>
                        <td>${prod.nome}</td>
                        <td>${prod.valor}</td>
                        <td>${prod.peso}</td>
                        <td>${prod.destaque}</td><!-- comment -->
                        <td>${prod.ativo}</td>
                       <td>
                           <a href="produto_update.jsp?idP=${prod.idprodutos}" class="btn btn-warning">[A]</a>
                           <form action="../prodControler" method="post" id="fdel${prod.idprodutos}">
                                <input type="hidden" name="act" value="delete">
                                <input type="hidden" name="idP" value="${prod.idprodutos}">
                                <button class="btn btn-danger" type="button" onclick="avisoDel('${prod.nome}',${prod.idprodutos});" >[ X ]</button>
                            </form>
                        </td> 
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
                
              </main>
            </div>
        </div>
              
        <script type="text/javascript">
            function avisoDel(nom, idP) {
                var ok = confirm("Deseja excluir a Produto "+nom+"???");
                if (ok) {
                    var div = document.getElementById("fdel"+idP).submit();
                }
            }
        </script>
    </body>
</html>