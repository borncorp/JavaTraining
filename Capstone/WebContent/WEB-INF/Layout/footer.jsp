			<div class="row clearfix">
				<div class="col-md-4 column">
					<h2>
						Heading
					</h2>
					<p>
						Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
					</p>
					<p>
						<a class="btn" href="#">View details »</a>
					</p>
				</div>
				<div class="col-md-4 column">
					<h2>
						Heading
					</h2>
					<p>
						Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
					</p>
					<p>
						<a class="btn" href="#">View details »</a>
					</p>
				</div>
				<div class="col-md-4 column">
					<div class="row clearfix">
						<div class="col-md-12 column">
							<img alt="140x140" src="http://lorempixel.com/140/140/" class="img-circle">
						</div>
					</div> <address> <strong>Twitter, Inc.</strong><br> 795 Folsom Ave, Suite 600<br> San Francisco, CA 94107<br> <abbr title="Phone">P:</abbr> (123) 456-7890</address>
				</div>
			</div>
		</div>
	</div>
</div>

<c:if test="${sessionScope.isloggedin != null}">
	 </br>You are logged In </br>
</c:if>

<c:if test="${sessionScope.isadmin == true}">
You are Admin </br>
</c:if>

<strong>Copyright Born 2014 </strong>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>