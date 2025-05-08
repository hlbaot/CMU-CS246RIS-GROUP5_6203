import java.util.Objects;

/**
 * Lớp DiceSum đại diện cho việc cộng kết quả của hai lần tung xúc xắc.
 * <p>
 * Lý do refactor:
 * - Sửa lỗi cú pháp ở phiên bản gốc (thiếu dấu chấm phẩy, lỗi tên biến).
 * - Đổi tên biến và format lại code cho dễ đọc.
 * - Thêm Javadoc để người khác dễ hiểu mục đích và cách hoạt động của lớp.
 * </p>
 *
 * <p>
 * Chức năng bổ sung:
 * - Thêm kiểm tra dữ liệu đầu vào (validation) trong constructor:
 *   Nếu r1 hoặc r2 là null, sẽ ném ra IllegalArgumentException để tránh lỗi NullPointerException sau này.
 * </p>
 */
public class DiceSum extends DieRoll {
    private DieRoll r1;
    private DieRoll r2;

    /**
     * Khởi tạo một đối tượng DiceSum với hai đối tượng DieRoll.
     *
     * @param r1 Lần tung xúc xắc thứ nhất (không được null).
     * @param r2 Lần tung xúc xắc thứ hai (không được null).
     * @throws IllegalArgumentException nếu r1 hoặc r2 là null.
     */
    public DiceSum(DieRoll r1, DieRoll r2) {
        super(0, 0, 0); // Gọi constructor cha với giá trị mặc định.
        /Check nếu r1 hoặc r2 bị null thì ném ra ngoại lệ, đảm bảo hai tham số không được null
        if (r1 == null || r2 == null) {
            throw new IllegalArgumentException("DiceSum constructor error: r1 and r2 must not be null.");
        }

        this.r1 = r1;
        this.r2 = r2;
    }

    /**
     * Thực hiện hai lần tung xúc xắc và trả về kết quả kết hợp của chúng.
     *
     * @return RollResult kết hợp giữa hai lần tung xúc xắc.
     */

    public RollResult makeRoll() {
        RollResult first = r1.makeRoll();
        RollResult second = r2.makeRoll();
        return first.andThen(second);
        System.out.println("2");
    }

    /**
     * Trả về biểu diễn chuỗi của hai lần tung xúc xắc.
     *
     * @return Chuỗi mô tả hai lần tung xúc xắc, nối bằng " & ".
     */
    @Override
    public String toString() {
        return r1.toString() + " & " + r2.toString();
    }
}
