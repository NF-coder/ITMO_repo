from src.app import OdeConsoleApp
import traceback


if __name__ == "__main__":
    try:
        OdeConsoleApp().run()
    except KeyboardInterrupt:
        print("Программа прервана пользователем.")
    except Exception as error:
        print(f"Критическая ошибка: {error}")
        traceback.print_exc()
