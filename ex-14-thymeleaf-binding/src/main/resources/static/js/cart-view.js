document.addEventListener('DOMContentLoaded', () => {
	const cartCountBtn = document.getElementsByClassName('cartCountBtn')
	const cartItemForm = document.getElementById('cartItemForm')
	const productIdInput = document.getElementById('productIdInput')
	const countInput = document.getElementById('countInput')
	
	if(cartCountBtn && cartItemForm && productIdInput && countInput) {
		Array.from(cartCountBtn).forEach(btn => btn.addEventListener('click', () => {
			productIdInput.value = btn.dataset.productId
			countInput.value = btn.dataset.productCount
			cartItemForm.submit()
		}))
	}
})