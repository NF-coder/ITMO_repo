import xmltodict
import json

class Converter():
    def __init__(self):
        pass

    def main(self, file: str) -> str:
        return json.dumps(
            xmltodict.parse(file),
            indent=4,
            ensure_ascii=False
        )