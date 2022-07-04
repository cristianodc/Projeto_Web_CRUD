<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="_inc/_verificasession.jsp" %>
<%@include file="_inc/_header.jsp" %>

 <div class="container">
            <div class="row">
              
              <%@include file="_inc/_menu.jsp" %>

              <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h2>Lista das Categorias</h2>
                    <a href="categorias.jsp" class="btn btn-info">Voltar</a>
                </div>
                  <form action="../prodControler" method="post">
                      
                    <input type="hidden" name="act" value="inserir" >
                            <div class="row mb-3">
                              <label for="inputEmail3" class="col-sm-2 col-form-label">Nome</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="nome">
                              </div>
                            </div>
                            <div class="row mb-3">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">Descricao</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="descricao">
                              </div>
                            </div>
                           <div class="row mb-3">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">Mais informações</label>
                              <div class="col-sm-10">
                                  <textarea type="text" class="form-control" name="maisinfo">
                                      
                                  </textarea>                                 
                              </div>
                            </div>
                           <div class="row mb-3">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">Valor</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="val">
                              </div>
                            </div>
                           <div class="row mb-3">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">Peso</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="peso">
                              </div>
                            </div>
                           <div class="row mb-3">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">Destaque</label>
                              <div class="col-sm-10">
                                  <input type="radio"  name="dtq" value="s" checked="checked" > Sim <br>
                                  <input type="radio"  name="dtq" value="n"> Não
                              </div>
                            </div>
                          <div class="row mb-3">
                              <label for="inputPassword3" class="col-sm-2 col-form-label">Categoria</label>
                              <div class="col-sm-10">
                                  <jsp:useBean class="br.com.projetoloja.repository.CategoriaDAO" id="lista"/>
                                
                                  <select name="catId">
                                  <c:forEach items="${lista.categoria}" var="objCat">
                                    <option value="${objCat.idcategorias}">${objCat.nome}</option>
                                  </c:forEach>
                                  </select>
                              </div>
                            </div>
                          
                            <button type="submit" class="btn btn-primary">Cadastra</button>
                         
                  </form>
                
                
              </main>
            </div>
        </div>
              
        <script type="text/javascript">
            function avisoDel(nom, idc) {
                var ok = confirm("Deseja excluir a categoria "+nom+"???");
                if (ok) {
                    var div = document.getElementById("fdel"+idc).submit();
                }
            }
        </script>
    </body>
</html>