from PIL import Image
import numpy as np
import glob
from typing_extensions import Union

def get_all_images(images_dir_path: str = "./images", formats: list[str] = ["png", "jpg", "jpeg", "gif"]) -> list[str]:
    result = []
    for image_format in formats:
        result.extend( glob.glob(f'{images_dir_path}/*.{image_format}'))
    return result

def calculate_average_brightness(image_path) -> Union[int, None]:
    """
    Вычисляет среднюю яркость изображения с помощью PIL
    
    Args:
        image_path (str): путь к изображению
    
    Returns:
        float: средняя яркость (0-255)
    """
    try:
        # Открываем изображение и конвертируем в оттенки серого
        image = Image.open(image_path).convert('L')
        
        # Преобразуем в numpy array
        img_array = np.array(image)
        
        # Вычисляем среднюю яркость
        average_brightness = np.mean(img_array)
        
        return average_brightness
    
    except Exception as e:
        print(f"Ошибка: {e}")
        return None

if __name__ == "__main__":
    for image_path in get_all_images():
        brightness = calculate_average_brightness(image_path)

        if brightness is not None:
            print(f"Средняя яркость изображения: {brightness:.0f}")