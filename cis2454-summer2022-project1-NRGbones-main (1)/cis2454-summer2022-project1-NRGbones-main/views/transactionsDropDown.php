<select name="user_id">
    <?php foreach ( $transaction as $transactions ) : ?>
    <option value='<?php echo $transactions['user_id'] ?>'><?php echo $transactions['stock_id'] ?> </option>
    <?php endforeach; ?>
</select>
