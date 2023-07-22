document.addEventListener('DOMContentLoaded', () => {
	
	const logoutForm = document.getElementById('logoutForm')
	const logoutMenu = document.getElementById('logoutMenu')
	
	if(logoutForm && logoutMenu) {
		logoutMenu.addEventListener('click', () => logoutForm.submit())
	}
})