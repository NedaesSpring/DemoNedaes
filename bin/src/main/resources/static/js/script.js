var selects = document.getElementsByClassName('select-text');

var allInputs = document.getElementsByClassName('material-inputs');
var materialInput = document.getElementsByClassName('material-dropdown__input');
var selectList = document.getElementsByClassName('material-dropdown__select-options-list');
var optionList = document.getElementsByClassName('material-dropdown__select-option');


for (var i = 0; i < selects.length; i++) {
	var selectId = selects[i].getAttribute('id');
	var options = selects[i].getElementsByTagName("option");
	var selected = false;
	var selectedText = "";

	/* Create options ul */

	/* Create list container */

	var container = document.createElement('div');
	container.className = 'material-dropdown__select-options';

	var listedOptions = "";
	var selectedClass = "";

	for (var j = 0; j < options.length; j++) {
		if (options[j].getAttribute("selected") == null) {
			selectedClass = "";
		}
		else {
			selected = true;
			selectedClass = "active";
			selectedText = options[j].text;
		}

		if (options[j].value != "") {
			listedOptions += '<div class="material-dropdown__select-option ' + selectedClass + '" data-input-id="' + selectId + '" data-option-text="' + options[j].text + '" data-option-id="' + options[j].value + '" role="option" aria-selected="false" aria-disabled="false" selected="false">' +
				'<span class="select-option-text">' + options[j].text + '</span>' +
				'</div>';
		}
	}

	/*  Create Input  */
	var input = document.createElement('input');
	input.type = 'text';
	if (selected == true) {
		input.className = "material-dropdown__input material-inputs valueActive visited-input";
	}
	else {
		input.className = "material-dropdown__input material-inputs";
	}
	input.setAttribute('id', selectId + '__input');
	input.setAttribute('name', selectId + '__input');
	input.setAttribute('readonly', "");
	input.value = selectedText;

	if (selects[i].getAttribute('required') != null) {
		input.setAttribute('required', "");
	}

	if (selects[i].getAttribute('disabled') != null) {
		input.setAttribute('disabled', "");
	}

	var parentNode = selects[i].parentNode;

	parentNode.insertBefore(input, selects[i]);

	/* Create span Arrow */
	var arrow = document.createElement('span');
	arrow.className = 'select-arrow';

	parentNode.insertBefore(arrow, selects[i]);

	/* Paint options ul */
	container.innerHTML = '<div class="material-dropdown__select-options-list" id="' + selectId + '__options">' + listedOptions + '</div>';

	parentNode.insertBefore(container, selects[i]);
}

for (var i = 0; i < allInputs.length; i++) {

	if (allInputs[i].value != "") {
		allInputs[i].classList.add('visited-input');
	}

	if (allInputs[i].getAttribute('disabled') != null) {
		let formGroup = allInputs[i].parentNode;
		formGroup.classList.add('disabled');
	}

	/* Focus input */
	allInputs[i].addEventListener('focusin', function() {
		closeDropdowns();
		if (this.classList.contains("material-dropdown__input")) {
			this.classList.add('active');
		}
	});

	/* Insert/remove value input */
	allInputs[i].addEventListener('keyup', function() {
		if (this.value != "") {
			this.classList.add('visited-input');
		}
		else {
			this.classList.remove('visited-input');
		}
	});

}

for (var i = 0; i < optionList.length; i++) {
	/* Focus input dropdown */
	optionList[i].addEventListener('click', function() {
		var inputValue = this.getAttribute('data-option-text');
		var selectId = this.getAttribute('data-input-id');
		var selectValue = this.getAttribute('data-option-id');
		var inputName = document.getElementById(selectId + '__input');
		var optionsId = selectId + '__options';

		unselectOptions(optionsId);
		this.classList.add('active');

		inputName.value = inputValue;
		inputName.classList.add('visited-input');
		inputName.classList.add('valueActive');

		document.getElementById(selectId).value = selectValue;
	});
}


var closeDropdowns = function() {
	for (var i = 0; i < materialInput.length; i++) {
		materialInput[i].classList.remove('active');
	}
};

var unselectOptions = function(el) {
	closeDropdowns();
	var options = document.getElementById(el);
	var insideOptionList = options.getElementsByClassName('material-dropdown__select-option');
	for (var i = 0; i < insideOptionList.length; i++) {
		insideOptionList[i].classList.remove('active');
	}
};

function includeHTML() {
	var z, i, elmnt, file, xhttp;
	/*loop through a collection of all HTML elements:*/
	z = document.getElementsByTagName("*");
	for (i = 0; i < z.length; i++) {
		elmnt = z[i];
		/*search for elements with a certain atrribute:*/
		file = elmnt.getAttribute("include-html");
		if (file) {
			/*make an HTTP request using the attribute value as the file name:*/
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4) {
					if (this.status == 200) { elmnt.innerHTML = this.responseText; }
					if (this.status == 404) { elmnt.innerHTML = "Page not found."; }
					/*remove the attribute, and call this function once more:*/
					elmnt.removeAttribute("w3-include-html");
					includeHTML();
				}
			}
			xhttp.open("GET", file, true);
			xhttp.send();
			/*exit the function:*/
			return;
		}
	}
};
function eliminar(id) {

	console.log(id);

	swal({

		title: "Esta seguro de Eliminar?",

		text: "Una vez eliminado no se prodra restablecer!",

		icon: "warning",

		buttons: true,

		dangerMode: true,

	})

		.then((OK) => {

			if (OK) {

				$.ajax({

					url: "/delete/" + id,

					success: function(res) {

						console.log(res);

					},

				});

				swal("Poof! Registro eliminado!", {

					icon: "success",

				}).then((ok) => {

					if (ok) {

						location.href = "/listar";

					}

				});

			}

		});

}
