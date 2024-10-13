public class TsvTitleDeserializer implements TitleDeserializer{
    @Override
    public Title deserialize(String value) {
        String[] columns = value.split("\t");
        return new Title(columns[0], Title.TitleType.valueOf(columns[1].toUpperCase()), columns[2]);
    }
}
