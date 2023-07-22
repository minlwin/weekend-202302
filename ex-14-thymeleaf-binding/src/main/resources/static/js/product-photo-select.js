document.addEventListener('DOMContentLoaded', () => {
	
	const controls = document.getElementsByClassName('controllImages')
	const cover = document.getElementById('coverImage')
	
	if(controls && cover) {

		cover.addEventListener('mouseenter', () => cover.classList.add('shadow'))
		cover.addEventListener('mouseleave', () => cover.classList.remove('shadow'))
		
		Array.from(controls).forEach(image => {
			image.addEventListener('click', () => cover.src = image.src)
			image.addEventListener('mouseenter', () => image.classList.add('shadow'))
			image.addEventListener('mouseleave', () => image.classList.remove('shadow'))
		})
		
	}
})