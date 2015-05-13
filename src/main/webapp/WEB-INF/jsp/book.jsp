<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/img/icon.jpg">

    <title>Library@CJ</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/dashboard.css" rel="stylesheet">
    
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Library</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
			
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
          
          <button type="button" class="btn btn-success navbar-right" data-toggle="modal" data-target="#createBookBtn" data-whatever="@mdo">new book</button>

        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">book type</h1>

		<!-- 书籍百分比 -->
          <div class="row placeholders">
            <div class="widget-content">
				<div class="row">
					<div class="col-md-3">
						<div class="easy-pie-chart green" data-percent="70">
							<span class="percent">60</span>
						</div>
						<p class="text-center">gospel</p>
					</div>
					<div class="col-md-3">
						<div class="easy-pie-chart red" data-percent="22">
							<span class="percent">12</span>
						</div>
						<p class="text-center">train</p>
					</div>
					<div class="col-md-3">
						<div class="easy-pie-chart yellow" data-percent="65">
							<span class="percent">18</span>
						</div>
						<p class="text-center">biography</p>
					</div>
					<div class="col-md-3">
						<div class="easy-pie-chart red" data-percent="87">
							<span class="percent">10</span>
						</div>
						<p class="text-center">bible study</p>
					</div>
				</div>
			</div>
          </div>

          <h2 class="sub-header">book list</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>name</th>
                  <th>author</th>
                  <th>description</th>
                  <th>type</th>
                  <th>remain</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>


	<!-- new book btn -->
	<div class="modal fade" id="createBookBtn" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">New Book</h4>
				</div>
				<form>
					<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="control-label">name:</label>
							<input type="text" class="form-control" id="recipient-name">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">description:</label>
							<textarea class="form-control" id="message-text"></textarea>
						</div>
						<div class="form-group">
							<div>
								<label for="recipient-name" class="control-label">author:</label>
								<input type="text" class="form-control-philip" id="recipient-name">
							</div>
							<div>
								<label for="recipient-name" class="control-label">editor:</label>
								<div class="btn-group">
								  <button class="btn dropdown-toggle" data-toggle="dropdown" href="#" value="fuyin书房">
								    fuyin书房
								    <span class="caret"></span>
								  </button>
								  <ul class="dropdown-menu">
									<li><a tabindex="-1" href="#" value="grace书房">grace书房</a></li>
									<li><a tabindex="-1" href="#" value="haiwai书房">haiwai书房</a></li>
							  	</ul>
								</div>
							</div>
						</div>
						<div>
							<label for="recipient-name" class="control-label">total:</label>
							<input type="text" class="form-control-philip" placeholder="Type something…">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">close</button>
						<button type="button" class="btn btn-primary">submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script src="/jquery/jquery.min.js"></script>
    <script src="/js/bootstrap.js"></script>
  </body>
</html>
