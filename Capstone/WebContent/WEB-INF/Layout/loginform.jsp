					<div class="col-md-3 column">
						<c:if test="${empty sessionScope.isloggedin}">
							<form role="form" action="Login" method="post">
								<div class="form-group">
									<label for="username">Username</label><input type="text"
										class="form-control" id="username" name="username">
								</div>
								<div class="form-group">
									<label for="password">Password</label><input type="password"
										class="form-control" id="password" name="password">
								</div>
								<button type="submit" class="btn btn-primary">Login</button>
								<a href="./register.jsp">
									<button type="button" class="btn btn-danger">Register</button>
								</a>
								<div class="form-group">
							</form>
						</c:if>
						<c:if test="${sessionScope.isloggedin != null}">
							<div class="row clearfix">
								<div class="col-md-12 column">
									<img alt="140x140" src="http://lorempixel.com/140/140/"
										class="img-thumbnail">
									<div class="row clearfix">
										<div class="col-md-12 column">
											<span class="label label-success">LoggedIn</span>
											<c:if test="${sessionScope.isadmin == true}">
												<span class="label label-primary">Admin</span>
											</c:if>
										</div>
									</div>
									<br>
									<div class="btn-group-vertical" role="group" aria-label="...">

										<a href="./Profile">
											<button type="button" class="btn btn-default">Profile</button>
										</a> <a href="./Logout">
											<button type="button" class="btn btn-default">Logout</button>
										</a>
									</div>
								</div>
						</c:if>
					</div> 