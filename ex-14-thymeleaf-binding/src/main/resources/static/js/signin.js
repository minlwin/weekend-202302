document.addEventListener('DOMContentLoaded', () => {
	
	const signInForm = document.getElementById('signInForm')
	const signUpForm = document.getElementById('signUpForm')
	const signInBtn = document.getElementById('signInBtn')
	const signUpBtn = document.getElementById('signUpBtn')
	
	
	if(signInForm && signUpForm && signInBtn && signUpBtn) {
		
		signUpBtn.addEventListener('click', () => {
			signUpForm.classList.remove('d-none')
			signInForm.classList.add('d-none')
		})
		
		signInBtn.addEventListener('click', () => {
			signInForm.classList.remove('d-none')
			signUpForm.classList.add('d-none')
		})
		
	}
	
})