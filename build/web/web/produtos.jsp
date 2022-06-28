<%@include  file="./includes/_header.jsp" %>

    <%-- 
    *******************************************
    Menus que irão ser carregados dinamicamente
    ******************************************
    --%>
 
    <%@include file="./includes/_menu.jsp" %>
   <%-- 
    *******************************************
    FIM DA NAV
    ******************************************
    --%>
  <div class="container px-4 py-4" id="custom-cards">
    <h2 class="pb-2 border-bottom">Produtos da Categoria em destaque</h2>
    <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
      
      <div class="col">
        <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" 
             style="background-image: url('https://picsum.photos/400/200?random=11');">
          <div class="d-flex flex-column h-100 p-3 pb-3 text-white text-shadow-1">
            <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Nome do Produto em Destque</h2>
            <ul class="d-flex list-unstyled mt-auto">
              <li class="me-auto">
                R$ 123,00
              </li>
              <li class="d-flex align-items-center me-3">
                <small>Nome Categoria</small>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <div class="col">
        <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" 
             style="background-image: url('https://picsum.photos/400/200?random=12');">
          <div class="d-flex flex-column h-100 p-3 pb-3 text-white text-shadow-1">
            <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Nome do Produto em Destque</h2>
            <ul class="d-flex list-unstyled mt-auto">
              <li class="me-auto">
                R$ 123,00
              </li>
              <li class="d-flex align-items-center me-3">
                <small>Nome Categoria</small>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <div class="col">
        <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" 
             style="background-image: url('https://picsum.photos/400/200?random=13');">
          <div class="d-flex flex-column h-100 p-3 pb-3 text-white text-shadow-1">
            <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Nome do Produto em Destque</h2>
            <ul class="d-flex list-unstyled mt-auto">
              <li class="me-auto">
                R$ 123,00
              </li>
              <li class="d-flex align-items-center me-3">
                <small>Nome Categoria</small>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <div class="col">
        <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" 
             style="background-image: url('https://picsum.photos/400/200?random=14');">
          <div class="d-flex flex-column h-100 p-3 pb-3 text-white text-shadow-1">
            <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Nome do Produto em Destque</h2>
            <ul class="d-flex list-unstyled mt-auto">
              <li class="me-auto">
                R$ 123,00
              </li>
              <li class="d-flex align-items-center me-3">
                <small>Nome Categoria</small>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <div class="col">
        <div class="card card-cover h-100 overflow-hidden text-white bg-dark rounded-5 shadow-lg" 
             style="background-image: url('https://picsum.photos/400/200?random=15');">
          <div class="d-flex flex-column h-100 p-3 pb-3 text-white text-shadow-1">
            <h2 class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold">Nome do Produto em Destque</h2>
            <ul class="d-flex list-unstyled mt-auto">
              <li class="me-auto">
                R$ 123,00
              </li>
              <li class="d-flex align-items-center me-3">
                <small>Nome Categoria</small>
              </li>
            </ul>
          </div>
        </div>
      </div>

    </div>
  </div>

    <%@include file="./includes/_footer.jsp" %>

</main>

<script src="./assets/js/bootstrap.bundle.min.js"></script>   
</body>
</html>
