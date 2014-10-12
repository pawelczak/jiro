var Gallery = {
		
		
		app: "image-viewer",
		imgSrc: "image-src",
		imgTitle: "image-title",
		
		init: function() {
			if ($(".gallery-image"). length > 0) {
				Gallery.assign();
			}
		},
		
		assign: function() {
			
			$(".gallery-image").each(function() {
				var $this = $(this);
				$this.on("click", function() {
					var src = $this.attr("src");
					
					Gallery.create($this);
					
				});
			});
		},
		
		create: function(image) {
			var $window = $("<div id='" + Gallery.app + "' class='" + Gallery.app + "' ></div>"),
				$content = $("<div class='container' ></div>"),
				$closeButton = $("<div class='close-gallery' ></div>");
			
			$closeButton.on("click", function() {
				Gallery.close();
			});
			
			$content.prepend("<div class='image-frame' ><img id='" + Gallery.imgSrc + "' src='" + image.attr("src") + "' data-title='" + image.attr("data-title") + "' /></div>");
			
			$content.prepend("<h2 id='" + Gallery.imgTitle + "' >" + image.attr("data-title") + "</h2>");
			
			$content.prepend($closeButton);
			
			$window.prepend($content);
			
			$(".wrapper").prepend($window);
			
			Gallery.createLib();
		},
		
		createLib: function() {
			var $container = $("<div class='image-container' ></div>"),
				$img = "";
			
			$(".gallery-image").each(function() {
				var src = $(this).attr("src"),
					title = $(this).attr("data-title");
				
				$img = $("<img src='" + src + "' />");
				
				$img.on("click", function() {
					Gallery.change(src, title);
				});
				
				$container.append($img);	
			});
			
			$("." + Gallery.app).append($container);
		},
		
		change: function(src, title) {
			$("#" + Gallery.imgSrc).attr("src", src);
			$("#" + Gallery.imgTitle).html(title);
		},
		
		close: function() {
			$("#" + Gallery.app).remove();
			
		},
};


$(document).ready(function() {
	
	Gallery.init();
});

