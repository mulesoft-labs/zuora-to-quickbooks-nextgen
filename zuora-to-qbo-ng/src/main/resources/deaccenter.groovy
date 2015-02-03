import java.text.Normalizer;
import java.util.regex.Pattern;

String str = payload.toString();
str = str.replace("¿", "o");
str = str.replace("¾", "a");
str = str.replace("Œ", "a");

String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

return pattern.matcher(nfdNormalizedString).replaceAll("");
