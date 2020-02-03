package pojo.question;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Awesome Pojo Generator
 * */
@Getter
public class Headings{
  @SerializedName("heading")
  @Expose
  private String heading;
}