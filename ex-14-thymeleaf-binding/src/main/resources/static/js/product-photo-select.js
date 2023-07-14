document.addEventListener('DOMContentLoaded', () => {
	
	const controls = document.getElementsByClassName('controllImages')
	const cover = document.getElementById('coverImage')
	
	if(controls && cover) {
		Array.from(controls).forEach(image => {
			image.addEventListener('click', () => cover.src = image.src)
		})
	}
})