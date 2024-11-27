from .test_obj import Test

class Dataset():
    def __init__(self, *args, name: str = "Test") -> None:
        self.tests_array = args
        self.name = name

    def __len__(self):
        return len(self.tests_array)
    
    def __getitem__(self, idx):
        _ = self.tests_array[idx]
        return (idx+1, _.test, _.result, _.flags)