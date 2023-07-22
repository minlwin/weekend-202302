document.addEventListener('DOMContentLoaded', () => {
	const editForm = document.getElementById('editForm')
	const addFeature = document.getElementById('addFeature')
	const addFeatureBtn = document.getElementById('addFeatureBtn')
	
	if(editForm && addFeature && addFeatureBtn) {
		addFeatureBtn.addEventListener('click', () => {
			addFeature.value = 1
			editForm.submit()
		})
	}
	
	const deleteButtons = Array.from(document.getElementsByClassName('delete-btn'))
	const deleteIndex = document.getElementById('deleteIndex')
	
	if(deleteButtons && deleteIndex && editForm) {
		deleteButtons.forEach(button => {
			button.addEventListener('click', () => {
				deleteIndex.value = button.dataset.appIndex
				editForm.submit()
			})
		})
	}
})