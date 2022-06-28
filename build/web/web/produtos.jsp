<%@page import="br.com.projetoloja.model.Produto"%>
<%@page import="java.util.List"%>
<%@include  file="./includes/_header.jsp" %>
<%@include file="./includes/_menu.jsp" %>
<%@page import="br.com.projetoloja.repository.ProdutoDAO" %>%>
  <%
      /*
        1) Pegar  o parametro "idc" que bem da URL (id da categoria)
        2) Criar um objeto DAO para consultar por ID de categoria
        3) Usar retorno lista para exibir os dados (aqui não usamos o useBean)
      */
     String id = request.getParameter("idc");
     Long idL =0L;
     try {
             idL =Long.parseLong(id);
         } catch (Exception e) {
            idL =0L;
         }
         
      ProdutoDAO dao = new ProdutoDAO();
      List<Produto> listaP  = dao.buscar("categorias_idcategorias ="+ idL);
      pageContext.setAttribute("listaP", listaP);
  %>
  <div class="container px-4 py-4" id="custom-cards">
    <h2 class="pb-2 border-bottom">Produtos da Categoria em destaque</h2>
    <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
        
      
            <c:forEach items="${listaP}" var="prod">
                <div class="col">
                  <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" 
                       style="background-image: url('https://picsum.photos/400/200?random=${prod.idprodutos}');">
                    <div class="d-flex flex-column h-100 p-3 pb-3 text-white text-shadow-1">
                      <h3 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">${prod.nome}</h3>
                      <ul class="d-flex list-unstyled mt-auto">
                        <li class="me-auto">
                          ${prod.valor}
                        </li>
                        <li class="d-flex align-items-center me-3">
                          <small>${prod.categorias_idcategorias}</small>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
            </c:forEach>

    </div>
  </div>

    <%@include file="./includes/_footer.jsp" %>

</main>

<script src="./assets/js/bootstrap.bundle.min.js"></script>   
</body>
</html>
