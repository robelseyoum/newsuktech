package com.example.newsuktech.components

import com.example.newsuktech.R


data class MUButtonModel(
    val titleStr: String? = null,
    val title: Int? = null,
    val style: MUButtonStyle
)

val PrimaryButton = MUButtonModel(
    title = R.string.mu_button_next,
    style = PrimaryButtonStyle()
)

val SecondaryButton = MUButtonModel(
    title = R.string.mu_button_back,
    style = SecondaryButtonStyle()
)

val SecondaryGoBackButton = MUButtonModel(
    title = R.string.mu_button_go_back,
    style = SecondaryButtonStyle()
)

val ApplyButton = MUButtonModel(
    title = R.string.mu_button_apply,
    style = CompleteButtonStyle()
)

val ConfirmButton = MUButtonModel(
    title = R.string.mu_button_confirm,
    style = CompleteButtonStyle()
)

val DeleteButton = MUButtonModel(
    title = R.string.mu_button_delete,
    style = DeleteButtonStyle()
)

val CancelButton = MUButtonModel(
    title = R.string.mu_button_cancel,
    style = SecondaryButtonStyle()
)

val BookInstallButton = MUButtonModel(
    title = R.string.mu_button_book_install,
    style = PrimaryButtonStyle()
)

val OKButton = MUButtonModel(
    title = R.string.mu_button_ok,
    style = SecondaryButtonStyle()
)

val SaveButton = MUButtonModel(
    title = R.string.mu_button_save,
    style = CompleteButtonStyle()
)

val NoThanksButton = MUButtonModel(
    title = R.string.mu_button_no_thanks,
    style = SecondaryButtonStyle()
)

val RateNowButton = MUButtonModel(
    title = R.string.mu_button_rate_now,
    style = PrimaryButtonStyle()
)
val WithdrawButton = MUButtonModel(
    title = R.string.mu_button_withdraw,
    style = CompleteButtonStyle()
)
