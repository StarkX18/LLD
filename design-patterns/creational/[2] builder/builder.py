class House:
    def __init__(self, builder):
        self.builder = builder

    def build(self):
        self.builder.build_floor()
        self.builder.build_size()
        self.builder.build_color()

    def get_house(self):
        return self.builder.house


class Builder:
    def __init__(self):
        self.house = None

    def build_floor(self):
        raise NotImplementedError

    def build_size(self):
        raise NotImplementedError

    def build_color(self):
        raise NotImplementedError


if __name__ == "main":
    builder = Builder()
    house = House(builder)
    house.build()
    house.get_house()
