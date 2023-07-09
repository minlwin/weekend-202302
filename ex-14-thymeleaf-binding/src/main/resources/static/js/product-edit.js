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
})