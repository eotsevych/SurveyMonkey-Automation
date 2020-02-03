package pojo.question;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Awesome Pojo Generator
 * */
@Getter
public class Required{
  @SerializedName("amount")
  @Expose
  private Integer amount;
  @SerializedName("text")
  @Expose
  private String text;
  @SerializedName("type")
  @Expose
  private String type;
}