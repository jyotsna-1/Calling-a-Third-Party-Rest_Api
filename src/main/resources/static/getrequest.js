GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#getALlBooks").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "getBooks",
					success : function(result) {
						if (result != 0) {
							$('#getResultDiv ul').empty();
							var custList = "";
							
							$.each(result,function(i, book) {
										var user = "Book Title = "
												+ book.bookTitle
												+ ", Author  = " + book.author
												+ ", Year Published  = " + book.publishedYear
												+ "<br>";
										$('#getResultDiv .list-group').append(
												user)
									});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})