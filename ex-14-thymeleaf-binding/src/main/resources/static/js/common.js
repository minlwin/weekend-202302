document.addEventListener('DOMContentLoaded', () => {
	const logoutMenu = document.getElementById('logoutMenu')
	const logoutForm = document.getElementById('logoutForm')
	
	if(logoutMenu && logoutForm) {
		logoutMenu.addEventListener('click', () => {
			logoutForm.submit()
		})
	} 
})