function campoFecha(idFecha) {
	
	}

	function campoAutoCompletado(idTextoCampo, idCodigoCampo, tagName,url) {
		jQuery("#" + idTextoCampo).autocomplete(
				{
					source : function(request, response) {
						jQuery.ajax({
							url : url,
							dataType : "json",
							headers : {
								"Content-Type" : "application/json",
								"Accept" : "application/json"
							},
							data : {
								maxRows : 10,
								tagName : tagName,
								valor : jQuery("#" + idTextoCampo).val()
							},
							success : function(data) {
								response(jQuery.map(data, function(item) {
									return {
										label : item.tagName,
										value : item.id
									}
								}));
							},
							error : function(jqXHR, textStatus, errorThrown) {
								var exceptionAjax = jQuery
										.parseJSON(jqXHR.responseText);
								dialogMensaje_abrir("Error recuperando lista, "
										+ exceptionAjax.message
										+ ".Póngase en contacto con soporte");
							}
						});
					},
					minLength : 3,
					select : function(event, ui) {
						event.preventDefault();
						jQuery("#" + idCodigoCampo).val(ui.item.value);
						this.value = ui.item.label;

					},
					change : function(event, ui) {
						if (!ui.item) {
							jQuery(this).val('');
							jQuery("#" + idCodigoCampo).val('');
						}
					},
					open : function() {
						jQuery(this).removeClass("ui-corner-all").addClass(
								"ui-corner-top");
					},
					close : function() {
						jQuery(this).removeClass("ui-corner-top").addClass(
								"ui-corner-all");
					}
				});
	}