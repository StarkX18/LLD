class singleton():
    __instance = None

    def __init__(self):
        if singleton.__instance != None:
            raise Exception("This class is a singleton!")
        else:
            singleton.__instance = self

    @staticmethod
    def getInstance():
        if singleton.__instance == None:
            singleton()
        return singleton.__instance